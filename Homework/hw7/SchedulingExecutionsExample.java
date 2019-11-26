/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the stack machine.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
import java.util.Scanner;

public class SchedulingExecutionsExample {

    private static MyStack valueStack = new MyStack();
    private static MyQueue instructionQ = new MyQueue();

    /**
     * This class is a main menu that you can execute.
     * It will be the hub of your program and will prompt the user for inputs which correlate to the functions you implement below
     * DO NOT MODIFY THE CODE FOR MAIN. It is already implemented for you.
     * @param args
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //this allows the user to enter in values when prompted

        int menuChoice = -1;
        while(menuChoice!=0){ //while loop that keeps going until user prompts it to stop
            System.out.println("Insert an integer based on what functionality you want then press enter to continue");
            System.out.println("1. create an instruction");
            System.out.println("2. execute your instructions");
            System.out.println("3. reset your current state");
            System.out.println("0. exit the program");
            menuChoice = sc.nextInt();

            if (menuChoice == 1){  //this will ask for inputs and lead to the fill function below
                sc.nextLine();
                System.out.println("insert the type of operation you wish to create: (LOAD, STORE, ADD, MUL, SUB, DIV, MOD;)");
                String oType = sc.nextLine();
                oType = oType.toUpperCase();

                MyOperation op = null;
                if (oType.equals("LOAD")){
                    System.out.println("insert a value (int) to put into the system:");
                    int val = sc.nextInt();
                    op = new MyOperation(OpType.LOAD,val);
                }else if (oType.equals("STORE")){
                    op = new MyOperation(OpType.STORE);
                }else if (oType.equals("ADD")){
                    op = new MyOperation(OpType.ADD);
                }else if (oType.equals("MUL")){
                    op = new MyOperation(OpType.MUL);
                }else if (oType.equals("SUB")){
                    op = new MyOperation(OpType.SUB);
                }else if (oType.equals("DIV")){
                    op = new MyOperation(OpType.DIV);
                }else if (oType.equals("MOD")){
                    op = new MyOperation(OpType.MOD);
                }else{
                    System.out.println("this was not a valid operation");
                }

                if (op!=null){
                    System.out.println("insert a duration (int) to be associated with this operation:");
                    int dur = sc.nextInt();
                    fill(op,dur);
                }

            }else if (menuChoice == 2){ //this will ask for inputs and lead to the execute function below

                System.out.println("insert a duration (int) for how long you wish to run your instructions:");
                int len = sc.nextInt();
                execute(len);

            }else if (menuChoice == 3){ //this wil lead to the flush function below
                flush();
            }else if (menuChoice!=0){
                System.out.println("this was not a valid menu option");
            }

        }

        sc.close();
    }


    /**
     * insert elements into your instruction Queue to be executed at a later time
     *
     * @param o the type and value associated with the operation. This should be based off of user input in the main method.
     * @param dur how long the instruction takes to execute
     */
    public static void fill(MyOperation o, int dur){
        instructionQ.enqueue(dur, o);
    }

    /**
     * should execute the instructions inside of your Queue for as long as you still have time to execute them by doing the required work and
     *      removing them from the Queue.
     * for each type of operation:
     *      Load places a value on your stack
     *      Store prints a value to the screen and removes it from the stack
     *      Opertations such as ADD, MUL, SUB, DIV, MOD should use the stockOperations function to perform arithmatic
     * The end of the execute function should print how many instructions you were executed and the total execution time for those instructions.
     *
     * @param time the amount of time you have to execute instructions
     */
    public static void execute(int time){
        int counter = 0;
        int duration = 0;
        while(duration < time) {
            Instruction inst = instructionQ.dequeue();
            // Get operation from instruction
            MyOperation op = inst.getOp();
            
            if(op.getType() == OpType.LOAD)
                valueStack.push(op.getValue());
            else if(op.getType() == OpType.STORE) {
                System.out.println(op.getValue());
                valueStack.pop();
            } else
                stackOperations(op.getType());
            // Get duration from instruction and add it to duration variable
            duration += inst.getDuration();
            // Tracks how many instructions were executed
            counter++;

        }
        System.out.println("Number of instructions exectuted: " + counter);
        System.out.println("Duration: " + duration);
    }

    /**
     * clear everything out of your instruction Queue and value Stack
     */
    public static void flush(){
        // Remove values until both valueStack and instructionQ are empty
        while(!valueStack.isEmpty()) {
            valueStack.pop();
        }
        while(!instructionQ.isEmpty()) {
            instructionQ.dequeue();
        }
    }

    /**
     * This function uses the stack to perform arithmetic operations.
     * Opertations such as ADD, MUL, SUB, DIV, MOD do the corresponding arithmetic computation by popping the top 2 elements
     *           from the stack then pushing the result onto the stack.
     *           For example in substraction, it would be the bottom element - the top element of the 2 that you pulled out.
     *              if the stack has Bottom--> 3 --> 1 --> top, SUB would perform 3-1.
     * If there is a reason the execution may not work or is invalid, print the error to the screen
     *
     * @param type The type of arithmetic operation that you want to execute.
     */
    public static void stackOperations(OpType type){
        int num1 = valueStack.pop();
        int num2 = valueStack.pop();

        if(type == OpType.ADD) {
            int sum = num1 + num2;
            valueStack.push(sum);
        } else if(type == OpType.MUL) {
            int product = num1 * num2;
            valueStack.push(product);
        } else if(type == OpType.SUB) {
            int difference = num2 - num1;
            valueStack.push(difference);
        } else if(type == OpType.DIV) {
            if(num1 == 0)
                System.out.println("Error: Divide by zero");
            else {
                int quotient = num2 / num1;
                valueStack.push(quotient);
            }
        } else if(type == OpType.MOD) {
            int mod = num2 % num1;
            valueStack.push(mod);
        } else {
            System.out.println("Error: Invalid operation");
        }
    }

    // Feel free to add any auxilary functions you may find useful below this point


}
