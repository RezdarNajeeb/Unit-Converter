import javax.swing.*;

public class Converter {
    static boolean reset = true;

    public void InputsAndResults() {
        while (reset) {
            double Input;
            try {
                String[] options = {"Mile \uD83D\uDD01 Yard", "Radian \uD83D\uDD01 Degree ", "Celsius \uD83D\uDD01 Kelvin", "Pound[lbs] \uD83D\uDD01 Ounce[oz]", "Bit \uD83D\uDD01 Nibble"};

                String[] conversions = {"Mile \u2192 Yard,Yard \u2192 Mile", "Radian \u2192 Degree,Degree \u2192 Radian", "Celsius \u2192 Kelvin,Kelvin \u2192 Celsius", "Pound[lbs] \u2192 Ounce[oz],Ounce[oz] \u2192 Pound[lbs]", "Bit \u2192 Nibble,Nibble \u2192 Bit"};

                Input = JOptionPane.showOptionDialog(null, "Choose your conversion in following:", "Unit Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (Input == -1) {
                    System.exit(0);
                }

                for (int i = 0; i < options.length; i++) {

                    if (Input == i) {
                        Input = JOptionPane.showOptionDialog(null, "Which one?", options[i], JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, conversions[i].split(","), options[0]);

                        if (Input == -1) {
                            System.exit(0);
                        }

                        if (Input == 0) {
                            Input = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a number:", options[i], JOptionPane.PLAIN_MESSAGE).replaceAll(" ", ""));

                            if (Input == -1) {
                                System.exit(0);
                            }


                            double[] results = {MileToYard(Input), RadToDeg(Input), CToK(Input), PoundToOunce(Input), BitToNibble(Input)};

                            JOptionPane.showMessageDialog(null, Input + " " + options[i].split("\uD83D\uDD01")[0] + " = " + results[i] + options[i].split("\uD83D\uDD01")[1], options[i], JOptionPane.PLAIN_MESSAGE);
                            Continue();
                            break;
                        } else {
                            Input = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a number:", options[i], JOptionPane.PLAIN_MESSAGE).replaceAll(" ", ""));

                            if (Input == -1) {
                                System.exit(0);
                            }

                            double[] rev_results = {YardToMile(Input), DegToRad(Input), KToC(Input), OunceToPound(Input), NibbleToBit(Input)};

                            JOptionPane.showMessageDialog(null, Input + " " + options[i].split("\uD83D\uDD01")[1] + " = " + rev_results[i] + " " + options[i].split("\uD83D\uDD01")[0], options[i], JOptionPane.PLAIN_MESSAGE);
                            Continue();
                            break;
                        }
                    }
                }


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid!!!!!\nOnly numbers are allowed", "Unit Converter", JOptionPane.PLAIN_MESSAGE);
                reset = true;
            }
        }

    }

    public void start() {
        int start = JOptionPane.showConfirmDialog(null, "Enter to start", "Unit Converter", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/images/logo.jpg"));
        if (start == -1) {
            System.exit(0);
        }
    }

    public static void Continue() {
        int Continue = JOptionPane.showConfirmDialog(null, "Do you want more conversion?", "Unit Converter", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        reset = Continue == 0;
    }

    public static double MileToYard(double Input) {
        return (Input * 1760);
    }

    public static double YardToMile(double Input) {
        return (Input / 1760);
    }

    public static double RadToDeg(double Input) {
        return (Input * (180 / 3.14));
    }

    public static double DegToRad(double Input) {
        return (Input * (3.14 / 180));
    }

    public static double CToK(double Input) {
        return (Input + 273);
    }

    public static double KToC(double Input) {
        return (Input - 273);
    }

    public static double PoundToOunce(double Input) {
        return (Input * 16);
    }

    public static double OunceToPound(double Input) {
        return (Input / 16);

    }

    public static double BitToNibble(double Input) {
        return (Input / 4);

    }

    public static double NibbleToBit(double Input) {
        return (Input * 4);
    }
}