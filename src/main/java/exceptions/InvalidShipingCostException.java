package exceptions;

public class InvalidShipingCostException extends Exception{
    public InvalidShipingCostException(String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
