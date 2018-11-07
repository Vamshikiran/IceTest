package com.ice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by vamshikirangullapelly on 07/11/2018.
 */
public class TradeParserTest {
    @Test
    public void testXetra() throws Exception {
        Trade trade = TradeParser.parse("iIT1234567890;t1;p123.34");
        Assert.assertEquals("IT1234567890", trade.getIsin());
        Assert.assertEquals(new Integer(1), trade.getType());
        Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
    }

    @Test
    public void testLSE() throws Exception {
        Trade trade = TradeParser.parse("t1;iGB1234567890;p123.34");
        Assert.assertEquals("GB1234567890", trade.getIsin());
        Assert.assertEquals(new Integer(1), trade.getType());
        Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
    }

    @Test
    public void testLIFFE() throws Exception {
        Trade trade = TradeParser.parse("t1;iGB1234567890;p123.34;v1000");
        Assert.assertEquals("GB1234567890", trade.getIsin());
        Assert.assertEquals(new Integer(1), trade.getType());
        Assert.assertEquals(new BigDecimal("123.34"), trade.getPrice());
    }

    @Test
    public void testError1() {
        try {
            Trade trade = TradeParser.parse("iGB1234567890;p123.34");
            Assert.fail("Expected exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void testError2() {
        try {
            Trade trade = TradeParser.parse("iGB12345678901;p123.34");
            Assert.fail("Expected exception");
        } catch (Exception e) {
        }
    }

    @Test
    public void testError3() {
        try {
            Trade trade = TradeParser.parse("iGB12345678901;t2;p123.34;t1");
            Assert.fail("Expected exception");
        } catch (Exception e) {
        }
    }

}