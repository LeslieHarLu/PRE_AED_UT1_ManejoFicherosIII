package pre_aed_ut1_manejoficherosiii;
//Un método que muestra por pantalla lo siguiente   

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogicCalendarExtended {
    public static void main(String[] args) {
       
    }
    public String newCalendarExtended(String nuMonthYear, String letter) {
        String[] nameMonth = {"\n_______ E N E R O _______\n",
        "\n_______ F E B R E R O _____\n",
        "\n_______ M A R Z O _______\n",
        "\n_______ A B R I L _______\n",
        "\n_______ M A Y O _______\n",
        "\n_______ J U N I O ______\n",
        "\n_______ J U L I O ______\n",
        "\n_______ A G O S T O ______\n",
        "\n_____ S E P T I E M B R E ____\n",
        "\n_____ O C T U B R E ____\n",
        "\n_____ N O V I E M B R E ____\n",
        "\n______ D I C I E M B R E ______\n"};
        String calen = nameMonth[Integer.parseInt(nuMonthYear) - 1]
         + "\n  L   M   X   J   V   S   D\n"; 
        
        String[] week = {"L", "M", "X", "J", "V", "S", "D"};
        int[] year = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = year[Integer.parseInt(nuMonthYear)]; //"
        int nums = 0;
        int aux = 0;
        int hyphens = 0;
        for (int i = 0; i < week.length; i++) {
            if (letter.equals(week[i])) {
                hyphens = i;
            }
        }
        for (int i = 1; i <= days + aux; i++) {
            if (i <= hyphens && i % 8 != 0) {
                calen += "  - ";
                ++aux;
            } else if (i % 8 == 0) {
                calen += "\n";
                aux++;
                if (i <= hyphens) {
                    hyphens++;
                }
            } else {
                if (nums < 9) {
                    calen += "  " + (++nums) + " ";
                } else {
                    calen += " " + (++nums) + " ";
                }
            }
        }
        return calen;
    }
    public void overwritedFilex(String nuMonthYear, String letter, File file) {
        // true to append  // false to overwrite. 
        String calend = newCalendarExtended(nuMonthYear, letter);
        try {
            FileWriter fW = new FileWriter(file,false);
            BufferedWriter bW = new BufferedWriter(fW);
            
            bW.write(calend + "\n --- Se ha sobreescrito ---\n");
            bW.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void appendFilex(String nuMonthYear, String letter, File file) {
        // true to append  // false to overwrite. 
        String calend = newCalendarExtended(nuMonthYear, letter);
        try {
            FileWriter fW = new FileWriter(file,true);
            BufferedWriter bW = new BufferedWriter(fW);
            
            bW.write("\n --- Se anadido nuevo contenido ---\n" + calend);
            bW.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    

    public void writeFilex(String nuMonthYear, String letter, File file) {
        
        String calend = newCalendarExtended(nuMonthYear, letter);

        try {
            FileWriter fW = new FileWriter(file);
            BufferedWriter bW = new BufferedWriter(fW);

            bW.write(calend);
            bW.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
