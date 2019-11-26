/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program defines the Insctruction class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class Instruction {

    private int duration;
    private MyOperation op;

    public Instruction(int duration, MyOperation operation){
        op = operation;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public MyOperation getOp() {
        return op;
    }

    @Override
    public String toString() {
        return "Instruction with op="+op.toString()+" and duration="+duration;
    }
}
