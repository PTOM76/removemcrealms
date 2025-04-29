package net.pitan76.removemcrealms.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.pitan76.removemcrealms.CommonClass;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Button.Builder.class)
public abstract class ButtonBuilderMixin {
    @Shadow @Final private Component message;

    @Shadow public abstract Button.Builder size(int pWidth, int pHeight);

    @Shadow public abstract Button.Builder bounds(int pX, int pY, int pWidth, int pHeight);

    @Shadow private int width;

    @Shadow private int y;

    @Shadow public abstract Button.Builder pos(int pX, int pY);

    @Shadow public abstract Button.Builder width(int pWidth);

    @Inject(at = @At("HEAD"), method = "build")
    private void build(CallbackInfoReturnable<Button> cir) {
        if (!CommonClass.mixiningScreen) return;

        if (!(message instanceof MutableComponent)) return;
        MutableComponent mutableMessage = (MutableComponent) message;
        if (!(mutableMessage.getContents() instanceof TranslatableContents)) return;

        TranslatableContents contents = (TranslatableContents) mutableMessage.getContents();

        // Remove Minecraft Realms
        if (contents.getKey().equals("menu.online")) {
            size(0, 0);
        }

        // Change the pos and width of NeoForge "Mods" button
        if (contents.getKey().equals("fml.menu.mods")) {
            width(200);
        }

    }
}
