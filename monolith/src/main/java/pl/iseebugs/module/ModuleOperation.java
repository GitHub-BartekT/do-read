package pl.iseebugs.module;

import java.util.*;

public class ModuleOperation {
    private List<ModuleDTO> data;

    public ModuleOperation(List<ModuleDTO> list) {
        data = new ArrayList<>(list);
    }

    void mixSessionToLastSentence(){
        final int lastIndex = data.size() - 1;
        ModuleDTO lastElement = data.get(lastIndex);
        Collections.shuffle(data);
        int indexLastElementAfterShuffle = data.indexOf(lastElement);
        if (indexLastElementAfterShuffle != lastIndex){
            ModuleDTO tempElement = data.get(lastIndex);
            int newIndexTempElement = data.lastIndexOf(lastElement);
            data.set(lastIndex,lastElement);
            data.set(newIndexTempElement, tempElement);
        }
        for(int i = 0; i < data.size(); i ++) {
            data.get(i).setId(i+1);
        }
    }

    public List<ModuleDTO> getData() {
        return data;
    }

    public void setData(List<ModuleDTO> data) {
        this.data = data;
    }
}
