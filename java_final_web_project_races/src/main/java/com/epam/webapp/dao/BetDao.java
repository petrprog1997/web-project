package com.epam.webapp.dao;

import com.epam.webapp.entity.Bet;
import com.epam.webapp.entity.BetStatus;
import com.epam.webapp.entity.BetType;

import java.util.List;

public interface BetDao extends Dao<Bet> {

    List<Bet> getByBetType(BetType betType);

    List<Bet> getByBetStatus(BetStatus betStatus);

    List<Bet> getByCoefficient(double coefficient);
}
