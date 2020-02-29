package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;

class GildedRose {
    private static final String[] SPECIAL_GOODS = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};

    private static final int BOTTOM_QUALITY = 0;
    private static final int CEILING_QUALITY = 50;

    private static final int QUALITY_INCREASE_RANGE = 1;
    private static final int QUALITY_DECREASE_RANGE = 1;

    private static final int SELL_IN_WARNING = 11;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String name = items[i].name;
            if (isSpecialGoods(name) && items[i].quality > BOTTOM_QUALITY) {
                items[i].quality -= QUALITY_DECREASE_RANGE;
            } else {
                if (items[i].quality < CEILING_QUALITY) {
                    items[i].quality += QUALITY_INCREASE_RANGE;

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
                        if (items[i].sellIn < SELL_IN_WARNING) {
                            if (items[i].quality < CEILING_QUALITY) {
                                items[i].quality += QUALITY_INCREASE_RANGE;
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!"Aged Brie".equals(items[i].name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                        if (items[i].quality > BOTTOM_QUALITY) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                                items[i].quality -= QUALITY_DECREASE_RANGE;
                            }
                        }
                    } else {
                        items[i].quality = BOTTOM_QUALITY;
                    }
                } else {
                    if (items[i].quality < CEILING_QUALITY) {
                        items[i].quality += QUALITY_INCREASE_RANGE;
                    }
                }
            }
        }
    }

    private boolean isSpecialGoods(String name) {
        return Arrays.stream(SPECIAL_GOODS)
            .filter(goods -> goods.equals(name))
            .collect(Collectors.toList())
            .size() == 0;
    }
}
