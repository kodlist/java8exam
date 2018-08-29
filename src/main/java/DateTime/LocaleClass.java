package DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.ResourceBundle;

/**
 * Created by mkoduri on 7/30/2018.
 */
public class LocaleClass {

    public static void main(String[] args) {


        String s1 = new String("Hello");
        System.out.println(s1.toLowerCase(Locale.CHINESE));
        Locale.setDefault(new Locale("ja", "JP"));
        Date now = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        String date = df.format(now);
        System.out.println(date);
        System.out.println(s1.toLowerCase());


        Locale locale_spanish = new Builder().setLanguage("es").setRegion("EU").build();
        System.out.println(s1.toLowerCase(locale_spanish));

       Locale j1Locale = Locale.JAPANESE;
        Locale j2Locale = new Locale.Builder().setLanguage("ja").build();
        System.out.println(s1.toLowerCase(j2Locale));
        Locale j3Locale = new Locale("ja");

        Locale[] locales = Locale.getAvailableLocales();
        Arrays.stream(locales).forEach((t) -> System.out.println(t) );
        System.out.println(locales.length);



        //Set them at application startup or where request cycle begin
        Locale.setDefault(Locale.Category.DISPLAY, Locale.US);
        Locale.setDefault(Locale.Category.FORMAT, Locale.FRANCE);

       /* ResourceBundle resourceBundle =  ResourceBundle.getBundle("bundleName", Locale.getDefault(Locale.Category.DISPLAY));
        String message = resourceBundle.getString("message.key");
        System.out.println("======= " + message);
        Date now = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        String date = df.format(now);
        System.out.println(date);*/

        System.out.println("Current Locale: " + Locale.getDefault());
        Locale.setDefault(new Locale("ms", "MY"));
        System.out.println("Current Locale: " + Locale.getDefault());
        System.out.println(s1.toLowerCase(new Locale("jp", "JP")));
      //  System.out.println("Current Locale: " + Locale.getDefault());

        Date date1 = new Date();
        int style = DateFormat.MEDIUM;
        df = DateFormat.getDateInstance(style, Locale.FRANCE);
        Locale.setDefault(new Locale("de", "DE"));
        df = DateFormat.getDateTimeInstance(style,style,Locale.GERMAN);
       // System.out.println("France: " + df.format(date1));
        Locale locale_swiss_italian = new Builder().setLanguage("it").setRegion("CH").build();
        //https://en.wikipedia.org/wiki/Language_localisation
        //https://stackoverflow.com/questions/1661325/simpledateformat-and-locale-based-format-string?noredirect=1&lq=1
        //https://docs.oracle.com/javase/tutorial/i18n/locale/create.html
        System.out.println(s1.toLowerCase(locale_swiss_italian));

        df = DateFormat.getDateTimeInstance(style,style,locale_swiss_italian);
        System.out.println("locale_swiss_italian: " + df.format(date1));
        System.out.println("locale_swiss_italian : "+s1.toLowerCase(locale_swiss_italian));


        //Date date = new Date();
        SimpleDateFormat dateFormatCN = new SimpleDateFormat("dd-MMM-yyyy", locale_swiss_italian);
        System.out.println(dateFormatCN.format(date1));


        //System.out.println(s1.toLowerCase(new Locale("es","PE")));

        SimpleDateFormat dateFormatCN1 = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println(" french and japan time ");
        LocalDate today = LocalDate.now();
        System.out.println("today date: "+today);
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.FRENCH)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.JAPANESE)));


    }
}
