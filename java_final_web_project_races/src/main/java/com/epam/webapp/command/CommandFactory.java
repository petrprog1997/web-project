package com.epam.webapp.command;

import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.exception.UnknownCommandException;
import com.epam.webapp.service.RaceParticipantService;
import com.epam.webapp.service.RunParticipantService;
import com.epam.webapp.service.RunService;
import com.epam.webapp.service.UserService;

public class CommandFactory {

    public static Command create(String command) throws UnknownCommandException {
        switch (command) {
            case "loginPage" :
                return new ShowPageCommand("/jsp/loginPage.jsp");
            case "login":
                return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout" :
                return new LogoutCommand();
            case "registrationPage" :
                return new ShowPageCommand("/jsp/registrationPage.jsp");
            case "registration" :
                return new RegistrationCommand(new UserService(new DaoHelperFactory()));
            case "mainPage":
                return new ShowPageCommand("/jsp/mainPage.jsp");
            case "usersPage" :
                return new ShowUsersPageCommand(new UserService(new DaoHelperFactory()));
            case "runsPage" :
                return new ShowRunsPageCommand(new RunService(new DaoHelperFactory()), new RaceParticipantService(new DaoHelperFactory()), new RunParticipantService(new DaoHelperFactory()));
            case "addRun" :
                return new AddRunCommand(new RunService(new DaoHelperFactory()),new RunParticipantService(new DaoHelperFactory()));
            case "addRunParticipant" :
                return new AddRunParticipantsCommand(new RunParticipantService(new DaoHelperFactory()));
            case "changeUserStatus":
                return new ChangeUserStatusCommand(new UserService(new DaoHelperFactory()));
            case "deleteRun" :
                return new DeleteRunCommand(new RunService(new DaoHelperFactory()),new RunParticipantService(new DaoHelperFactory()));
            default:
                throw new UnknownCommandException("Unknown command" + command);
        }
    }

}
