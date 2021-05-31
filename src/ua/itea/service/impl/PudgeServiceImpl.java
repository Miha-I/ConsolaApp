package ua.itea.service.impl;

import ua.itea.config.AppConfig;
import ua.itea.model.Pudge;
import ua.itea.repository.PudgeRepository;
import ua.itea.repository.impl.PudgeRepositoryImpl;
import ua.itea.service.PudgeService;

import java.util.*;
import java.util.logging.Logger;

public class PudgeServiceImpl implements PudgeService {

    public static final Logger logger = Logger.getLogger("PudgeService");

    private final String [] phrases_code = {"phrase1", "phrase2", "phrase3"};
    private final String messageBundleName = AppConfig.MESSAGE_BUNDLE_NAME;

    private final PudgeRepository pudgeRepository;

    public PudgeServiceImpl(){
        this.pudgeRepository = new PudgeRepositoryImpl(AppConfig.PUDGE_FILE_NAME);
    }

    @Override
    public Pudge getPudge(Locale locale) {
        Pudge pudge = pudgeRepository.find();
        if(pudge == null){
            pudge = new Pudge();
        }
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(messageBundleName, locale);
            List<String> phrases = new ArrayList<>(phrases_code.length);
            String phrase;
            for (String code : phrases_code) {
                if(!(phrase = resourceBundle.getString(code)).isEmpty()) {
                    phrases.add(phrase);
                }
            }
            pudge.setPhrases(phrases);
        } catch (MissingResourceException e){
            logger.info(e.getMessage());
        }
        return pudge;
    }

    @Override
    public void savePudge(Pudge pudge) {
        Pudge savedPudge = pudgeRepository.save(pudge);
        logger.info("save pudge - " + savedPudge.toString());
    }

    @Override
    public void editPudge(Pudge pudge) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter pudge name");
        String name = input.nextLine();
        pudge.setName(name);
        System.out.println("Enter pudge level");
        while (!input.hasNextInt()){
            System.out.println("You must enter number");
            input.next();
        }
        int level = input.nextInt();
        pudge.setLevel(level);
    }
}
