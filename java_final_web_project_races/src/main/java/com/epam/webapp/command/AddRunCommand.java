package com.epam.webapp.command;

import com.epam.webapp.entity.RaceParticipant;
import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.entity.RunStatus;
import com.epam.webapp.parser.RunParticipantParser;
import com.epam.webapp.service.RaceParticipantService;
import com.epam.webapp.service.RunParticipantService;
import com.epam.webapp.service.RunService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddRunCommand implements Command {

    private RunService runService;
    private RunParticipantService runParticipantService;

    public AddRunCommand(RunService runService, RunParticipantService runParticipantService) {
        this.runService = runService;
        this.runParticipantService = runParticipantService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String date = request.getParameter("date");
        Run run = new Run(date,RunStatus.PLANNED,0);
        runService.addRun(run);
        return CommandResult.redirect("/controller?command=runsPage");
    }
}
