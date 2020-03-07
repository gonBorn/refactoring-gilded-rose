package cn.xpbootcamp.gilded_rose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (sellIn < 11) {
            increaseQuality();
        }
        if (sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }

    @Override
    protected void updateQualityAfterExpired() {
        quality = 0;
    }

}
