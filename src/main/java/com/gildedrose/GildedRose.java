package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;

class GildedRose {
    private static final String[] SPECIAL_GOODS = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
    private static final int BOTTOM_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
//            if (!"Aged Brie".equals(items[i].name)
//                    && !"Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)
//                    && !"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
//                if (items[i].quality > 0) {
//                        items[i].quality = items[i].quality - 1;
//                }
//            }
            String name = items[i].name;
            int quality = items[i].quality;
            if (isSpecialGoods(name) && quality > BOTTOM_QUALITY) {
                items[i].quality = items[i].quality - 1;
            }

            else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                        if (items[i].sell_in < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                items[i].sell_in = items[i].sell_in - 1;
            }

            if (items[i].sell_in < 0) {
                if (!"Aged Brie".equals(items[i].name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                        if (items[i].quality > BOTTOM_QUALITY) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = BOTTOM_QUALITY;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
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
