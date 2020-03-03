package com.gildedrose.Items;

import com.gildedrose.Item;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpiration() {
        quality = 0;
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11 && quality < 50) {
                quality = quality + 1;
            }

            if (sellIn < 6 && quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
