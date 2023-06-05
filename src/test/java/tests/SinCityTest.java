package tests;

import base.TestBase;
import enumerators.SinType;
import models.Sin;

import org.junit.jupiter.api.Test;
import pages.SinCityPage;
import pages.SpartaPage;


import java.util.ArrayList;
import java.util.List;

public class SinCityTest extends TestBase {

    @Test
    public void testNewSin() {
        Sin spiderSin = new Sin("zabil som oboch robov", "furby", "zabil som ho lopatou");
        SinCityPage sinCityPage = new SinCityPage();
        List<SinType> spiderSinTags = new ArrayList<>();
        spiderSinTags.add(SinType.MURDER);
        spiderSinTags.add(SinType.ROBBERY);
        spiderSinTags.add(SinType.CAR_ACCIDENT);
        spiderSin.setTags(spiderSinTags);

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(spiderSin);
        sinCityPage.markTag(spiderSin.getTags());
        sinCityPage.confessSin();
        sinCityPage.checkSinStatus(spiderSin);
        sinCityPage.openDetail(spiderSin);

        sinCityPage.checkDetail(spiderSin);
    }

    @Test
    public void testForgive() {
        Sin evaSpieva = new Sin("spievame spolu", "dusan g. & eva m.", "spievame stale");
        SinCityPage sinCityPage = new SinCityPage();

        sinCityPage.openPage();
        sinCityPage.fillSinInformation(evaSpieva);
        sinCityPage.confessSin();

        SpartaPage spartaPage = new SpartaPage();
        spartaPage.openPage();
        spartaPage.forgiveSin(evaSpieva);

        sinCityPage.openPage();
        sinCityPage.checkSinStatus(evaSpieva);

    }
}
