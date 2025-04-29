package net.pitan76.removemcrealms.mixin;

import net.minecraft.client.gui.components.AbstractWidget;
import net.neoforged.neoforge.client.gui.widget.ModsButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractWidget.class)
public class AbstractWidgetMixin {

    @Shadow protected int width;

    @Inject(at = @At("TAIL"), method = "getWidth")
    private void getWidth(CallbackInfoReturnable<Integer> cir) {
        if ((AbstractWidget) (Object) this instanceof ModsButton) {
            if (width != 200) width = 200;
        }
    }
}
