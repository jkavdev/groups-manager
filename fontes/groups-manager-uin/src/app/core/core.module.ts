import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ButtonModule} from 'primeng/components/button/button';
import {MegaMenuModule} from 'primeng/components/megamenu/megamenu';
import {TieredMenuModule} from 'primeng/components/tieredmenu/tieredmenu';

import {NavbarComponent} from './navbar/navbar.component';

@NgModule({
  imports: [
    CommonModule,

    ButtonModule,
    MegaMenuModule,
    TieredMenuModule,
  ],
  declarations: [NavbarComponent],
  exports: [NavbarComponent]
})
export class CoreModule {
}
