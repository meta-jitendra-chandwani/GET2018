import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccordionModule } from 'primeng/accordion';     //accordion and accordion tab
import { TabViewModule } from 'primeng/tabview';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { CheckboxModule } from 'primeng/checkbox';
import {TableModule} from 'primeng/table';

@NgModule({
  exports: [
    CommonModule,
    AccordionModule,
    BrowserAnimationsModule,
    TabViewModule,
    DropdownModule,
    ButtonModule,
    CalendarModule,
    CheckboxModule,
    TableModule
  ],
  declarations: []
})
export class NgPrimeModule { }
