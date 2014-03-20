package protobufdsl.parse.tree;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import protobufdsl.parse.tree.primary.PrimaryANSI;
import protobufdsl.parse.tree.primary.PrimarySINT32;

/**
 * @author jackcptdev<jackcptdev@gmail.com>
 * @version Feb 26, 2014 2:24:06 PM
 * 
 */
public class TestObject {

    @Test
    public void testHashCode() {

        Map<Object, Object> map = new HashMap<Object, Object>();

        PrimaryANSI primaryANSIa = new PrimaryANSI();
        PrimaryANSI primaryANSIb = new PrimaryANSI();

        Assert.assertTrue(primaryANSIa.hashCode() == primaryANSIb.hashCode());
        Assert.assertTrue(primaryANSIa.equals(primaryANSIa));

        map.put(primaryANSIa, "value");
        Assert.assertTrue("value".equals(map.get(primaryANSIb)));

        Identifier ida = new Identifier("hello");
        Identifier idb = new Identifier("hello");
        Identifier idc = new Identifier("world");

        Assert.assertTrue(ida.hashCode() == idb.hashCode() && ida.equals(idb));
        Assert.assertTrue(ida.hashCode() != idc.hashCode() && !ida.equals(idc));

        map.put(ida, "valueida");
        map.put(idc, "valueidc");
        Assert.assertTrue("valueida".equals(map.get(idb).toString()) && !"valueidc".equals(idb.toString()));

        IntegerNumber inta = new IntegerNumber(1);
        IntegerNumber intb = new IntegerNumber(2);
        IntegerNumber intc = new IntegerNumber(3);
        IntegerNumber intd = new IntegerNumber(1);

        Assert.assertTrue(inta.hashCode() == intd.hashCode());
        Assert.assertTrue(inta.hashCode() != intb.hashCode());
        Assert.assertTrue(inta.hashCode() != intc.hashCode());

        Assert.assertTrue(inta.equals(intd));
        Assert.assertTrue(!inta.equals(intc));
        Assert.assertTrue(!inta.equals(intb));

        map.put(inta, "valuea");
        map.put(intb, "valueb");

        Assert.assertTrue("valuea".equals(map.get(intd)));
        Assert.assertTrue(!"valued".equals(map.get(intb)));

        RepeatedCount repeatedCountA = new RepeatedCount(inta, 100);
        RepeatedCount repeatedCountB = new RepeatedCount(intb, 100);
//        RepeatedCount repeatedCountC = new RepeatedCount(intc, 100);
        RepeatedCount repeatedCountD = new RepeatedCount(intd, 100);

        RepeatedCount repeatedCountE = new RepeatedCount(ida);
        RepeatedCount repeatedCountF = new RepeatedCount(idb);
        RepeatedCount repeatedCountG = new RepeatedCount(idc);

        Assert.assertTrue(repeatedCountA.hashCode() == repeatedCountD.hashCode()
                && repeatedCountA.equals(repeatedCountD) && repeatedCountE.hashCode() == repeatedCountF.hashCode()
                && repeatedCountE.equals(repeatedCountF));
        Assert.assertTrue(repeatedCountA.hashCode() != repeatedCountB.hashCode()
                && !repeatedCountA.equals(repeatedCountB) && repeatedCountE.hashCode() != repeatedCountG.hashCode()
                && !repeatedCountE.equals(repeatedCountG));

        map.put(repeatedCountA, "rvaluea");
        map.put(repeatedCountB, "rvalueb");
        map.put(repeatedCountE, "rvaluec");
        map.put(repeatedCountG, "rvalued");
        Assert.assertTrue("rvaluea".equals(map.get(repeatedCountD)) && "rvaluec".equals(map.get(repeatedCountF)));
        Assert.assertTrue(!"rvalueb".equals(map.get(repeatedCountD)) && !"rvalued".equals(map.get(repeatedCountF)));

        PrimaryType primaryTypeA = new PrimaryType(primaryANSIa, repeatedCountA);
        PrimaryType primaryTypeB = new PrimaryType(primaryANSIb, repeatedCountA);
        Assert.assertTrue(primaryTypeA.hashCode() == primaryTypeB.hashCode() && primaryTypeA.equals(primaryTypeB));
        map.put(primaryTypeA, "OKOK");
        Assert.assertTrue("OKOK".equals(map.get(primaryTypeB)));

        PrimarySINT32 primarySINT32 = new PrimarySINT32();
        PrimaryType primaryTypeC = new PrimaryType(primaryANSIa, repeatedCountA);
        PrimaryType primaryTypeD = new PrimaryType(primarySINT32, repeatedCountA);
        Assert.assertTrue(primaryTypeC.hashCode() != primaryTypeD.hashCode() && !primaryTypeC.equals(primaryTypeD));

        PrimaryType primaryTypeE = new PrimaryType(primaryANSIa, repeatedCountA);
        PrimaryType primaryTypeF = new PrimaryType(primaryANSIa, repeatedCountD);
        PrimaryType primaryTypeG = new PrimaryType(primaryANSIa, repeatedCountB);
        Assert.assertTrue(primaryTypeE.hashCode() == primaryTypeF.hashCode() && primaryTypeE.equals(primaryTypeF));
        Assert.assertTrue(primaryTypeE.hashCode() != primaryTypeG.hashCode() && !primaryTypeE.equals(primaryTypeG));

        Statement statementA = new Statement(inta, ida, primaryTypeA);
        Statement statementB = new Statement(intd, idb, primaryTypeB);
        Statement statementC = new Statement(intb, ida, primaryTypeA);
        Statement statementD = new Statement(intd, idc, primaryTypeA);
        Statement statementE = new Statement(intd, ida, primaryTypeD);
        at(statementA.hashCode() == statementB.hashCode() && statementA.equals(statementB));
        at(statementA.hashCode() != statementC.hashCode());
        at(!statementA.equals(statementC));
        at(statementA.hashCode() != statementD.hashCode());
        at(!statementA.equals(statementD));
        at(statementE.hashCode() != statementA.hashCode());
        at(!statementA.equals(statementE));

        Statement[] sa = new Statement[3];
        sa[0] = statementA;
        sa[1] = statementB;
        sa[2] = statementC;

        Statement[] sb = new Statement[3];
        sb[0] = statementB;
        sb[1] = statementA;
        sb[2] = statementC;

        StatementList sla = new StatementList(sa);
        StatementList slb = new StatementList(sb);

        at(sla.hashCode() == slb.hashCode());
        at(sla.equals(slb));

        Statement[] sc = new Statement[3];
        sc[0] = statementD;
        sc[1] = statementD;
        sc[2] = statementD;

        StatementList slc = new StatementList(sc);
        at(sla.hashCode() != slc.hashCode());
        at(!sla.equals(slc));

        map.put("oo", sla);
        at(!"oo".equals(map.get(slc)));

        CombinationType combinationTypeA = new CombinationType(sla, repeatedCountA);
        CombinationType combinationTypeB = new CombinationType(slb, repeatedCountA);
        CombinationType combinationTypeC = new CombinationType(sla, repeatedCountB);

        at(combinationTypeA.hashCode() == combinationTypeB.hashCode() && combinationTypeA.equals(combinationTypeB));
        at(combinationTypeA.hashCode() != combinationTypeC.hashCode() && !combinationTypeA.equals(combinationTypeC));

        Start startA = new Start(sla);
        Start startB = new Start(slb);
        Start startC = new Start(slc);

        at(startA.hashCode() == startB.hashCode());
        at(startA.equals(startB));
        at(startA.hashCode() != startC.hashCode());
        at(!startA.equals(startC));
    }

    private void at(boolean f) {
        Assert.assertTrue(f);
    }
}
