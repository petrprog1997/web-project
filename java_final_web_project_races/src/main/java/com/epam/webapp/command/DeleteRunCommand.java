package com.epam.webapp.command;

import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.service.RunParticipantService;
import com.epam.webapp.service.RunService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRunCommand implements Command {

    private RunService runService;
    private RunParticipantService runParticipantService;

    public DeleteRunCommand(RunService runService, RunParticipantService runParticipantService) {
        this.runService = runService;
        this.runParticipantService = runParticipantService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String runId = request.getParameter("runId");
        System.out.println(runId);
        Long id = Long.parseLong(runId);

        runService.deleteRun(id);
        runParticipantService.deleteRunParticipant(id);

        return CommandResult.redirect("/controller?command=runsPage");
    }
}
