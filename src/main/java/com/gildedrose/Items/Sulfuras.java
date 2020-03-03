package com.gildedrose.Items;

import com.gildedrose.Item;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpiration() {
        return;
    }

    @Override
    protected void updateQuality() {
        return;
    }

    @Override
    protected void updateSellIn() {
        return;
    }
}
