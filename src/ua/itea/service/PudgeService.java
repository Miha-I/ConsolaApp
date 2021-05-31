package ua.itea.service;

import ua.itea.model.Pudge;

import java.util.Locale;

public interface PudgeService {

    Pudge getPudge(Locale locale);

    void savePudge(Pudge pudge);

    void editPudge(Pudge pudge);
}
