public class SorterFactory {
    public Sorter getSorter(String sorterType) {
        if(sorterType == null) {
            return null;
        }
        return switch (sorterType.toUpperCase()) {
            case "BUBBLESORTER" -> new BubbleSorter();
            case "MERGESORTER" -> new MergeSorter();
            default -> null;
        };
        // TODO: exception handling for returning null Sorter
    }
}
