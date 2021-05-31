package ua.itea;

import ua.itea.model.Pudge;
import ua.itea.service.PudgeService;
import ua.itea.service.impl.PudgeServiceImpl;

import java.util.Locale;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger("main");

    private final PudgeService pudgeService;

    public Main() {
        this.pudgeService = new PudgeServiceImpl();
    }

    public static void main(String[] args) {
        LOG.info("start app");
        Main main = new Main();
        Locale locale = main.getLocale(args);
        Pudge pudge = main.pudgeService.getPudge(locale);
        System.out.println("Load pudge");
        main.printPudge(pudge);
        main.pudgeService.editPudge(pudge);
        System.out.println("Edit pudge");
        main.printPudge(pudge);
        main.pudgeService.savePudge(pudge);
    }

    private Locale getLocale(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "ru":
                    return new Locale("ru", "RU");
                case "de":
                    return new Locale("de", "DE");
                case "fr":
                    return new Locale("fr", "FR");
                default:
                    LOG.info("Wrong locale in []args, default locale ru");
                    return new Locale("ru", "RU");
            }
        }
        LOG.info("Locale not passed default locale ru");
        return new Locale("ru", "RU");
    }

    private void printPudge(Pudge pudge) {
        System.out.println(pudge);
    }
}
