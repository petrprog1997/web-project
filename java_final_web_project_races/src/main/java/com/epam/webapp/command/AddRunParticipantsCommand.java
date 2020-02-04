package com.epam.webapp.command;

import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.parser.RunParticipantParser;
import com.epam.webapp.service.RunParticipantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddRunParticipantsCommand implements Command {

    private RunParticipantService runParticipantService;

    public AddRunParticipantsCommand(RunParticipantService runParticipantService) {
        this.runParticipantService = runParticipantService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String runId = request.getParameter("runId");
        int id = Integer.parseInt(runId);

        String[] strRunParticipantList = request.getParameterValues("raceParticipant");
        for (String s : strRunParticipantList) {
            RunParticipant runParticipant = RunParticipantParser.parse(s);
            runParticipant.setRunId(id);
            runParticipantService.addRunParticipant(runParticipant);
        }

        return CommandResult.redirect("/controller?command=runsPage");
    }
}
