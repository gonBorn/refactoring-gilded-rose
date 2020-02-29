package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;

class GildedRose {
    private static final String[] SPECIAL_GOODS = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
    private static final String[] SELL_IN_WILL_NOT_CHANGE_GOODS = {"Sulfuras, Hand of Ragnaros"};
    private static final String[] LONGER_THE_TIME_MORE_VALIABLE_GOODS = {"Backstage passes to a TAFKAL80ETC concert"};

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
            if (isOrdinaryGoods(SPECIAL_GOODS, name) && items[i].quality > BOTTOM_QUALITY) {
                items[i].quality -= QUALITY_DECREASE_RANGE;
            } else {
                if (items[i].quality < CEILING_QUALITY) {
                    items[i].quality += QUALITY_INCREASE_RANGE;

                    if (!isOrdinaryGoods(LONGER_THE_TIME_MORE_VALIABLE_GOODS, name)) {
                        if (items[i].sellIn < SELL_IN_WARNING) {
                            if (items[i].quality < CEILING_QUALITY) {
                                items[i].quality += QUALITY_INCREASE_RANGE;
                            }
                        }
                    }
                }
            }

            if (isOrdinaryGoods(SELL_IN_WILL_NOT_CHANGE_GOODS, name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }

    private boolean isOrdinaryGoods(String [] specialGoods, String name) {
        return Arrays.stream(specialGoods)
            .filter(goods -> goods.equals(name))
            .collect(Collectors.toList())
            .size() == 0;
    }
}
