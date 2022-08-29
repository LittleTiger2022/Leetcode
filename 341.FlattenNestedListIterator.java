// s1
public class NestedIterator implements Iterator<Integer> {
 Queue<Integer> flatList = new LinkedList<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
    append(nestedList);    
    }

    private void append(List<NestedInteger> nestedList){
        for (NestedInteger ni : nestedList)
            if (ni.isInteger())
                flatList.add(ni.getInteger());
            else
                append(ni.getList());
    }
    @Override
    public Integer next() {
        return flatList.poll();
    }

    @Override
    public boolean hasNext() {
        return flatList.size() >0;
        
    }
}

// s2


