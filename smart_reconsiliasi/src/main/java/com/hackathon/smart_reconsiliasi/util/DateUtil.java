package com.hackathon.smart_reconsiliasi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    private static final DateTimeFormatter INDONESIAN_FORMATTER =
            DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("id", "ID"));

    private static final DateTimeFormatter ISO_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate parseTanggal(String indonesianDate) {
        LocalDate date = LocalDate.parse(indonesianDate, INDONESIAN_FORMATTER);
        return LocalDate.parse(date.format(ISO_FORMATTER));
    }
}

