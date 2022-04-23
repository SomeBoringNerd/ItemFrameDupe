package xyz.someboringnerd.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import xyz.someboringnerd.ItemFrameDupe;

import java.util.Random;

public class ItemFrameListener implements Listener
{
    private final ItemFrameDupe main = ItemFrameDupe.getPlugin(ItemFrameDupe.class);

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof ItemFrame){
            ItemFrame frame = (ItemFrame) event.getEntity();

            if(frame.getItem().getType() != Material.AIR)
            {

                if(0 + (int)(Math.random() * ((100 - 0) + 1)) <= main.getConfig().getInt("probability")){
                    Item item = event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), frame.getItem());
                    item.setVelocity(item.getVelocity().zero());
                }
            }
        }
    }
}
