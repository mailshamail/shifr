package ru.mailshamail.shifr.utils;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class utils {

    private static char[] Code_Atbash =
    {
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
            'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    };

    private static char[] Decode_Atbash =
            {
                    'Я', 'Ю', 'Э', 'Ь', 'Ы', 'Ъ', 'Щ', 'Ш', 'Ч', 'Ц', 'Х', 'Ф', 'У', 'Т', 'С', 'Р', 'П', 'О',
            'Н', 'М', 'Л', 'К', 'Й', 'И', 'З', 'Ж', 'Ё', 'Е', 'Д', 'Г', 'В', 'Б', 'А'
            };

    public utils() {}

    private static String ConverToString(ArrayList<String> text)
    {
        StringBuilder builder = new StringBuilder();
        for(String s : text) {
            builder.append(s);
        }
        String codeText = builder.toString();

        return codeText;

    }

    private static ArrayList<Integer> space(@NonNull String text)
    {
        ArrayList<Integer> spaceCoord = new ArrayList<>(text.length());

        for (int asfd = 0; asfd < text.length(); asfd++)
        {
            if (text.charAt(asfd) == '_' || text.charAt(asfd) == ' ' || text.charAt(asfd) == '-')
            {
                spaceCoord.add(asfd);
            }
        }
        return spaceCoord;
    }

    private static char[] deleteSimbols(@NonNull String text)
    {
        String t = text;
        char[] isText = razbiv(text.toUpperCase());
        for (int i3 = 0; i3 < text.length(); i3++)
        {
            if (text.charAt(i3) == '_' || text.charAt(i3) == '-' || text.charAt(i3) == ' ')
            {
                t = text.replace(String.valueOf(text.charAt(i3)), "").toUpperCase();
                isText = t.toCharArray();
            }
        }
        return isText;
    }




    private static char[] razbiv(@NonNull String s)
    {
        char[] q = new char[s.length()];

        for (int i = 0;i < s.length(); i++)
        {
            q[i] = s.charAt(i);
            //System.out.println("Element [" + i + "]: " + q[i]);
        }
        return q;
    }

    public static String codeAtbash(@NonNull String text)
    {
        String t;

        char[] q = razbiv(text.toUpperCase());
        char[] codeText;
        char[] code = Code_Atbash;
        char[] decode = Decode_Atbash;
        int[] d;

        ArrayList<Integer> po = space(text);

        for(int i3 =0; i3<text.length(); i3++)
        {
            if (text.charAt(i3) == '_')
            {
                t = text.replace(String.valueOf(text.charAt(i3)), "").toUpperCase();
                q = t.toCharArray();
            }
        }

        codeText = new char[q.length];
        d = new int[codeText.length];

        ArrayList<String> result = new ArrayList<>(codeText.length);


        for(int i = 0; i < q.length; i++){
            for(int ii = 0 ; ii < code.length; ii++)
            {
                if (q[i] == code[ii])
                {
                    d[i] = ii;
                }
            }
        }




       for(int s2 = 0; s2 < d.length; s2++) {
            for (int p = 0;p < decode.length; p++)
            {
                if (p == d[s2])
                {
                    codeText[s2] = decode[p];
                    result.add(s2, String.valueOf(decode[p]));

                }
            }
        }

       for(int fa = 0 ; fa < po.size(); fa++)
       {
           result.add(po.get(fa), "_");
       }


        StringBuilder builder = new StringBuilder();
        for(String s : result) {
            builder.append(s);
        }
        String str = builder.toString();

        System.out.println(text  +  " | code | " + str);
        return str.toLowerCase();
    }

    public static String decodeAtbash(@NonNull String text)
    {
        String t;

        char[] q = razbiv(text.toUpperCase());
        char[] codeText;
        char[] code = Code_Atbash;
        char[] decode = Decode_Atbash;
        int[] d;

        ArrayList<Integer> po;
        po = space(text);

        for (int i3 = 0; i3 < text.length(); i3++)
        {
            if (text.charAt(i3) == '_')
            {
                t = text.replace(String.valueOf(text.charAt(i3)), "").toUpperCase();
                q = t.toCharArray();
            }
        }

        codeText = new char[q.length];
        d = new int[codeText.length];

        ArrayList<String> result = new ArrayList<>(codeText.length);

        //System.out.println(t);

        for (int i = 0; i < q.length; i++) {
            for (int ii = 0; ii < decode.length; ii++) {
                if (q[i] == code[ii]) {
                    d[i] = ii;
                }
            }
        }


        for (int s2 = 0; s2 < d.length; s2++) {
            for (int p = 0; p < code.length; p++) {
                if (p == d[s2]) {
                    codeText[s2] = code[p];
                    result.add(s2, String.valueOf(decode[p]));
                }
            }
        }

        for (int fa = 0; fa < po.size(); fa++) {
            result.add(po.get(fa), "_");
        }


        StringBuilder builder = new StringBuilder();
        for (String s : result) {
            builder.append(s);
        }
        String str = builder.toString();

        System.out.println(text + " | decode | " + str);

        return str.toLowerCase();
    }

    public static String codeCezar(@NonNull String text, int k)
    {
        char[] isText = deleteSimbols(text.toUpperCase());

        ArrayList<Integer> sp = space(text);
        ArrayList<String> result = new ArrayList<>(text.length());


        for(int i = 0; i < isText.length; i++)
        {
            for(int i2 = 0; i2 < Code_Atbash.length; i2++)
            {
                if(isText[i] == Code_Atbash[i2])
                {
                    if((i2 + k) < Code_Atbash.length) {
                        result.add(i, String.valueOf(Code_Atbash[i2 + k]));
                    }else{
                        result.add(i, String.valueOf(Code_Atbash[(i2 - Code_Atbash.length) + k]));
                    }
                }
            }
        }

        for (int fa = 0; fa < sp.size(); fa++)
        {
            result.add(sp.get(fa), "_");
        }

        System.out.println(text  + " / " + ConverToString(result).toLowerCase());
        return ConverToString(result).toLowerCase();
    }

    public static String decodeCezar(@NonNull String text, int k)
    {
        char[] isText = deleteSimbols(text.toUpperCase());

        ArrayList<Integer> sp = space(text);
        ArrayList<String> result = new ArrayList<>(text.length());

        for(int i = 0; i < isText.length; i++)
        {
            for(int i2 = 0; i2 < Code_Atbash.length; i2++)
            {
                if(isText[i] == Code_Atbash[i2])
                {
                    if((i2 + k) <= Code_Atbash.length) {
                        result.add(i, String.valueOf(Code_Atbash[i2 - k]));
                    }else{
                        result.add(i, String.valueOf(Code_Atbash[(i2 - Code_Atbash.length) + k]));
                    }
                }
            }
        }

        for (int fa = 0; fa < sp.size(); fa++)
        {
            result.add(sp.get(fa), "_");
        }

        System.out.println(text  + " / " + ConverToString(result).toLowerCase());
        return ConverToString(result).toLowerCase();
    }

    public static String codePolibiy(@NonNull String text)
    {
        char[][] kvadrat = new char[6][6];

        ArrayList<Integer> space = space(text);
        ArrayList<String> result = new ArrayList<>(text.length());

        char[] charTextArray = deleteSimbols(text);

        int k = 0;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if(k >= Code_Atbash.length)
                {
                    kvadrat[i][j] = '-';
                }else {
                    kvadrat[i][j] = Code_Atbash[k];
                }
                k++;

                //System.out.print(kvadrat[i][j] + " ");
            }
            System.out.println();
        }

        for(int i3 = 0; i3 < charTextArray.length; i3++)
        {
            for (int i = 0; i < 6; i++)
            {
                for (int i2 = 0; i2 < 6; i2++)
                {
                    if (kvadrat[i][i2] == charTextArray[i3])
                    {
                        if(kvadrat[i][i2] == 'Э' || kvadrat[i][i2] == 'Ю' || kvadrat[i][i2] == 'Я' || kvadrat[i][i2] == '-' || kvadrat[i][i2] == 'Ь' || kvadrat[i][i2] == 'Ы' || kvadrat[i][i2] == 'Ъ')
                        {
                            result.add(i3, String.valueOf( kvadrat[0][i2]));
                        }else{
                            result.add(i3, String.valueOf(kvadrat[i+1][i2]));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < space.size(); i++)
        {
            result.add(space.get(i), "_");
        }

        System.out.println("Text: " + text + "| codeText: | " + result);

        return ConverToString(result).toLowerCase();
    }

    public static String decodePolibiy(@NonNull String text)
    {
        char[][] kvadrat = new char[6][6];

        ArrayList<Integer> space = space(text);
        ArrayList<String> result = new ArrayList<>(text.length());

        char[] charTextArray = deleteSimbols(text);

        int k = 0;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if(k >= Code_Atbash.length)
                {
                    kvadrat[i][j] = '-';
                }else {
                    kvadrat[i][j] = Code_Atbash[k];
                }
                k++;

                //System.out.print(kvadrat[i][j] + " ");
            }
            System.out.println();
        }

        for(int i3 = 0; i3 < charTextArray.length; i3++)
        {
            for (int i = 0; i < 6; i++)
            {
                for (int i2 = 0; i2 < 6; i2++)
                {
                    if (kvadrat[i][i2] == charTextArray[i3])
                    {
                        if(kvadrat[i][i2] == 'А' || kvadrat[i][i2] == 'Б' || kvadrat[i][i2] == 'В')
                        {
                            result.add(i3, String.valueOf(kvadrat[5][i2]));
                        }else if(kvadrat[i][i2] == 'Г' || kvadrat[i][i2] == 'Д' || kvadrat[i][i2] == 'Е') {
                            result.add(i3, String.valueOf(kvadrat[4][i2]));
                        }else {
                            result.add(i3, String.valueOf(kvadrat[i-1][i2]));
                        }
                    }
                }
            }
        }

        for(int i = 0; i < space.size(); i++)
        {
            result.add(space.get(i), "_");
        }

        System.out.println("Text: " + text + "| decodeText: | " + result);

        return ConverToString(result).toLowerCase();
    }
}
