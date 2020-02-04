package com.epam.webapp.parser;

import com.epam.webapp.entity.RunParticipant;

public class RunParticipantParser {

    public static RunParticipant parse(String strParticipant) {
        strParticipant = strParticipant.trim();
        strParticipant = strParticipant.replaceAll("\\s{2,}"," ").replace("RaceParticipant{","")
                .replace("horseName=","").replace(" runNumber=","")
                .replace("}","");
        String[] split = strParticipant.split(",");

        RunParticipant runParticipant = new RunParticipant(split[0],Integer.parseInt(split[1]),0);
        return runParticipant;
    }

}
