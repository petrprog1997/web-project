package com.epam.webapp.dao;

import com.epam.webapp.entity.Run;

import java.sql.Date;
import java.util.List;

public interface RunDao extends Dao<Run> {

    List<Run> getByRunDate(Date date);
}
