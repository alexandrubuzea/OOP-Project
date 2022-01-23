package elfstrategies;

import roundstatus.ChildStatus;

/**
 * An interface representing the pattern of a strategy, depending on the elf type
 */
public interface ElfStrategy {
    /**
     * A method which applies a strategy to the current status of a child, based on its
     * specifications
     * @param status
     */
    void applyGiftStrategy(ChildStatus status);
}
