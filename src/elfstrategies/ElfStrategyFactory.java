package elfstrategies;

import enums.ElvesType;

public class ElfStrategyFactory {
    private static ElfStrategyFactory factory = null;

    private ElfStrategyFactory () { }

    public static ElfStrategyFactory getElfStrategyFactory() {
        if (factory == null) {
            factory = new ElfStrategyFactory();
        }

        return factory;
    }

    public ElfStrategy createElfStrategy(ElvesType elf) {
        return switch (elf) {
            case WHITE -> new WhiteElfStrategy();
            case BLACK -> new BlackElfStrategy();
            case PINK -> new PinkElfStrategy();
            case YELLOW -> new YellowElfStrategy();
        };
    }
}
