package elfstrategies;

import roundstatus.ChildStatus;

/**
 * A class which performs a white elf strategy: because the white elf is old, he will not
 * perform any changes to the child status
 */
public class WhiteElfStrategy implements ElfStrategy {

    /**
     * The strategy applied: for the white elf, do nothing
     * @param status the status of the child we need to perform changes over.
     */
    @Override
    public void applyGiftStrategy(final ChildStatus status) {
        // do nothing
    }
}
