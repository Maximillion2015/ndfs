

package ndfs.core.common.model;


public class BlockInfoInHeartBeat {
    
    //块的唯一id
    private long id;
    
    //实际大小
    private long actualSize;

    public Long getId() {
    
        return id;
    }

    public void setId(long id) {
    
        this.id = id;
    }

    public long getActualSize() {
    
        return actualSize;
    }

    public void setActualSize(long actualSize) {
    
        this.actualSize = actualSize;
    }

}

    