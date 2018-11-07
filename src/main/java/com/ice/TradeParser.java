package com.ice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vamshikirangullapelly on 07/11/2018.
 */
public class TradeParser {

    private static final String TRADE_TYPE = "t";
    private static final String ISIN = "i";
    private static final String PRICE = "p";
    private static final int BEGIN_INDEX = 1;
    private static final int LIST_THRESHOLD = 3;

    public static Trade parse(String line) throws Exception {

        Trade trade = new Trade();
        List<String> validatedList = validateTrade(line);
        if (validatedList.isEmpty()) {
            throw new Exception();
        } else {
            for (String s : validatedList) {
                if (s.startsWith(TRADE_TYPE)) {
                    trade.setType(Integer.valueOf(s.substring(BEGIN_INDEX)));
                } else if (s.startsWith(ISIN)) {
                    trade.setIsin(s.substring(BEGIN_INDEX));
                } else if (s.startsWith(PRICE)) {
                    trade.setPrice(new BigDecimal(s.substring(BEGIN_INDEX)));
                }
            }
        }
        return trade;
    }

    private static List<String> validateTrade(String inputString) {
        boolean result = true;

        List<String> list =
                Stream.of(inputString.split(";"))
                        .collect(Collectors.toList());

        if (list.size() < LIST_THRESHOLD) {
            result = false;
        } else {
            int size = list.stream()
                    .filter(s -> s.startsWith(TRADE_TYPE))
                    .collect(Collectors.toList()).size();
            if (size > BEGIN_INDEX) {
                result = false;
            }

        }
        if (!result) {
            list.clear();
        }

        return list;
    }

}
