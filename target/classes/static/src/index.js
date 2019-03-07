import Vue from 'vue';
import router from './core/router';

import '../assets/css/slds-addons.css';
import '../assets/css/slds-branding.css';
import '../assets/css/slds-fontawesome-svg.css';
import '../assets/css/styles.css';
import '../assets/css/z-levels.css';

import App from './components/app.vue';


new Vue({
    el: '#app',
    render: h => h(App),
    router
});
