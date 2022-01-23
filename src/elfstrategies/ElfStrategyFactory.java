package elfstrategies;

import enums.ElvesType;

/**
 * A class which implements the Factory design pattern in order to create suitable strategies,
 * according to the given elf of the child. Because all factory instances would have been the
 * same, we created a Singleton Factory.
 */
public final class ElfStrategyFactory {
    /**
     * The static Singleton Factory instance.
     */
    private static ElfStrategyFactory factory = null;

    /**
     * The private constructor for the class.
     */
    private ElfStrategyFactory() { }

    /**
     * The method used in order to access the unique instance of the class.
     * @return the unique instance
     */
    public static ElfStrategyFactory getElfStrategyFactory() {
        if (factory == null) {
            factory = new ElfStrategyFactory();
        }

        return factory;
    }

    /**
     * A method which creates a suitable strategy for the given elf.
     * @param elf the elf type for which the strategy must be created
     * @return the desired strategy.
     */
    public ElfStrategy createElfStrategy(final ElvesType elf) {
        return switch (elf) {
            case WHITE -> new WhiteElfStrategy();
            case BLACK -> new BlackElfStrategy();
            case PINK -> new PinkElfStrategy();
            case YELLOW -> new YellowElfStrategy();
        };
    }
}
