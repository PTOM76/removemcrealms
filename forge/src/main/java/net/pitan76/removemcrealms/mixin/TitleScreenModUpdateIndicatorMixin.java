package net.pitan76.removemcrealms.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraftforge.client.gui.TitleScreenModUpdateIndicator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreenModUpdateIndicator.class)
public class TitleScreenModUpdateIndicatorMixin {
    @Shadow @Final private Button modButton;

    @Inject(method = "init()V", at = @At("TAIL"), remap = false)
    private void init(CallbackInfo info) {
        if (modButton == null) return;
        modButton.setWidth(200);
    }
}
