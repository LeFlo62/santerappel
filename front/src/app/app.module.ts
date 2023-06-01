import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { QAComponent } from './components/qa/qa.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { ContactComponent } from './components/contact/contact.component';
import { CertifiedInfoComponent } from './components/certified-info/certified-info.component';

import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { MultiSelectModule } from 'primeng/multiselect';
import { SkeletonModule } from 'primeng/skeleton';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InplaceModule } from 'primeng/inplace';
import { DividerModule } from 'primeng/divider';
import { AccordionModule } from 'primeng/accordion';
import { ChartModule } from 'primeng/chart';
import { StyleClassModule } from 'primeng/styleclass';
import { CarouselModule } from 'primeng/carousel';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { RippleModule } from 'primeng/ripple';
import { InputTextareaModule } from 'primeng/inputtextarea';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CertifiedInfoComponent,
    QAComponent,
    WelcomeComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    MenubarModule,
    FormsModule,
    ReactiveFormsModule,
    ButtonModule,
    SkeletonModule,
    DropdownModule,
    MultiSelectModule,
    InplaceModule,
    DividerModule,
    AccordionModule,
    ChartModule,
    StyleClassModule,
    CarouselModule,
    CardModule,
    InputTextModule,
    RippleModule,
    InputTextareaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
