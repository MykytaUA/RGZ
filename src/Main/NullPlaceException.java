package Main;

//Exception, который мы кидаем, когда происходит попытка записи в пустое место

public class NullPlaceException extends Exception
{
    public NullPlaceException()
    {
        System.out.println("Error: Попытка записи в несуществующее место");
    }

}
