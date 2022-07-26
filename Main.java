public class Main {
    public static String calc(String input){
        String sign = findSign(input);


        if (!sign.equals("0")) {
            String[] term = findTerms(input, sign);
            int[] iterms = {0, 0};
            int k = 0;


            if (term.length < 3) {

                try {
                    for (int i = 0; i < 2; i++) {
                        iterms[i] = Integer.parseInt(term[i]);

                    }
                    k = 2;
                }
                catch (NumberFormatException n) {

                    try {
                        for (int i = 0; i < 2; i++) {
                            iterms[i] = Romane.valueOf(term[i]).getIntnum();

                        }
                        k = 1;


                    } catch (IllegalArgumentException i) {
                        return "throws Exception";

                    }
                }


                int result = solve(iterms[0], iterms[1], sign);
                if (result == -10) return "throws Exception";
                if (k==2) return String.valueOf(result);
                if ((k == 1) && (result < 1)) return "throws Exception";
                if (k == 1) return intToRom(result);


            }
            else return "throws Exception";

        }

            return "throws Exception";



    }


    public static String findSign(String s){
        String[] signs = {"+", "-", "*", "/"};

        for (String sign: signs){
            int index = s.indexOf(sign);
            if (index != -1) {
                return "\\" + sign;
            }
        }

        return "0";
    }
    public static String[] findTerms(String s, String sign){
        String[] terms = s.split(sign);
        for (int i = 0; i < 2; i++){
            terms[i]= terms[i].trim();
        }
        return terms;
    }
    public static int solve(int a, int b, String sign){
        if ((a>0)&&(a<11)&&(b>0)&&(b<11)){
            switch (sign){
                case "\\+":
                    return a + b;
                case "\\-":
                    return a - b;
                case "\\*":
                    return a * b;
                case "\\/":
                    return a / b;
            }}
        return -10;
    }

    public static String intToRom(int a){
        if (a == 100) return "C";
        int dec = a / 10;
        String d = "";
        switch (dec){
            case 1:
                d = "X";
                break;
            case 4:
                d = "XL";
                break;
            case 5:
                d = "L";
                break;
            case 9:
                d = "XC";
                break;
            default:
                if (dec == 0) break;
                if (dec<5){
                    for (int i = 1; i < (dec+1); i++){
                        d = d + "X";

                    }
                    break;

                }
                else{
                    d = "L";
                    for (int i = 1; i < (dec - 4); i++){
                        d = d + "X";

                    }
                }



        }
        int unit = a % 10;
        String u = "";
        switch (unit){
            case 1:
                u = "I";
                break;
            case 4:
                u = "IV";
                break;
            case 5:
                u = "V";
                break;
            case 9:
                u = "IX";
                break;
            default:
                if (unit == 0) break;
                if (unit<5){
                    for (int i = 0; i < (unit); i++){
                        u = u+"I";

                    }
                    break;
                }
                else{
                    u = "V";
                    for (int i = 0; i < (unit - 5); i++){
                        u = u + "I";

                    }
                    break;
                }

        }
        return d+u;

    }
}



