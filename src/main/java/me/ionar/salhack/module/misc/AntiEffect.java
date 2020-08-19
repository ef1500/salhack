package me.ionar.salhack.module.misc;

import me.ionar.salhack.events.player.EventPlayerIsPotionActive;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.init.MobEffects;

public final class AntiEffectModule extends Module
{
  public final Value<Boolean> Poison = new Value<Boolean>("AntiPoison", new String[]
  { "ATP" }, "Prevents Poison effect", false);

    public AntiEffectModule()
    {
        super("AntiEffect", new String[]
        { "AntEffect" }, "Prevents you from taking certain effects", "NONE", 0xC224DB, ModuleType.MISC);
    }

    @EventHandler
    private Listener<EventPlayerIsPotionActive> IsPotionActive = new Listener<>(p_Event ->
    {
        if (p_Event.potion == MobEffects.POISON)
            p_Event.cancel();

    });
}
