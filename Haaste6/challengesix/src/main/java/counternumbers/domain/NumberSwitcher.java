package counternumbers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSwitcher {
    private List<Integer> original;
    private List<Integer> changed;

    
    public NumberSwitcher() {
        this.original = new ArrayList<>();
        this.changed = new ArrayList<>();
    }
    
    public void turnNumbers() {
        this.changed = this.original.stream()
            .map(n -> -n)
            .collect(Collectors.toList());
    }
    public List<Integer> getOriginal() {
        return original;
    }
    public void setOriginal(List<Integer> original) {
        this.original = original.stream().collect(Collectors.toList());
    }
    public void addToOriginal(int number) {
        this.original.add(number);
    }
    public List<Integer> getChanged() {
        return changed;
    }
    
    
}
