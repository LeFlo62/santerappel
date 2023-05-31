import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';

import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { MultiSelectModule } from 'primeng/multiselect';
import { SkeletonModule } from 'primeng/skeleton';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CertifiedInfoComponent } from './components/certified-info/certified-info.component';
import { InplaceModule } from 'primeng/inplace';
import { DividerModule } from 'primeng/divider';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CertifiedInfoComponent
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
    DividerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
