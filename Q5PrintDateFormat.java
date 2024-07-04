package JavaExercises;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q5PrintDateFormat {

    public static void main(String[] args){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String FormattedDate = sdf.format(currentDate);
        System.out.println("Formatted Date:"+FormattedDate);
    }
}
