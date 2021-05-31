package ua.itea.repository;

import ua.itea.model.Pudge;

public interface PudgeRepository {

    Pudge find();

    Pudge save(Pudge pudge);
}
