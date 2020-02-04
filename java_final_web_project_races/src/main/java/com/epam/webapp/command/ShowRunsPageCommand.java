package com.epam.webapp.command;

import com.epam.webapp.entity.RaceParticipant;
import com.epam.webapp.entity.Run;
import com.epam.webapp.entity.RunParticipant;
import com.epam.webapp.service.RaceParticipantService;
import com.epam.webapp.service.RunParticipantService;
import com.epam.webapp.service.RunService;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowRunsPageCommand implements Command {

    private RunService runService;
    private RaceParticipantService raceParticipantService;
    private RunParticipantService runParticipantService;

    public ShowRunsPageCommand(RunService runService, RaceParticipantService raceParticipantService,RunParticipantService runParticipantService) {
        this.runService = runService;
        this.raceParticipantService = raceParticipantService;
        this.runParticipantService = runParticipantService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Run> runList = runService.getAllRuns();
        request.setAttribute("runList",runList);

        List<RaceParticipant> raceParticipantList = raceParticipantService.getAllRaceParticipants();
        request.setAttribute("raceParticipants",raceParticipantList);

        List<RunParticipant> runParticipantList = runParticipantService.getAllRunParticipants();
        request.setAttribute("runParticipants",runParticipantList);

        return CommandResult.forward("/jsp/runsPage.jsp");
    }
}
