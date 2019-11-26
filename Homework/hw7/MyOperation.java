/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program defines the MyOperation class

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class MyOperation {

    private OpType type;
    private int value;    //keep as minimum value for load/store

    public MyOperation(OpType opType, int value){
        type = opType;
        this.value = value;
    }

    public MyOperation(OpType opType){
        type = opType;
        value = Integer.MIN_VALUE;
    }

    public OpType getType(){
        return type;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {

        if (value == Integer.MIN_VALUE){
            return "Operation with type="+type;
        }

        return "Operation with type="+type+" and value="+value;
    }
}
