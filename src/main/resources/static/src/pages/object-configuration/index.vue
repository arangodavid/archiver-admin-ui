<template>
    <section>
        <h1 class="slds-text-heading_large slds-m-bottom_x-large">Object Configuration</h1>
        <section class="primary-section">
            <section v-show="soapObjErrors.length">
                <p class="slds-required" 
                    v-for="soapObjError in soapObjErrors"
                >
                    {{soapObjError}}
                </p>
            </section>
            <form class="slds-form-element__form" 
                    v-show="soapObjs" 
                    @submit.prevent="deleteSoapObj" 
                    v-for="(soapObj, index) in soapObjs"
            >
                <label class="slds-text-color_weak">{{ title }}</label>
                <input :value="index" class="slds-form-element__input" type="text" :key="index"/>
                <input class="slds-button slds-button_destructive" type="submit" value="Delete" />
            </form>
            <form @submit.prevent="saveSoapObj" class="slds-form-element__form">
                <label class="slds-form-element__label">{{ title }}</label>
                <input class="slds-form-element__input" type="text" v-model="newSoapObj"/>
                <input class="slds-button slds-button_brand slds-form-element__save" type="submit" value="add" />
            </form>
        </section>
    </section>
</template>

<script>
    import API from '../../core/api.js';
    import EM from '../../core/event-emitter.js';
    import PageLoader from '../../components/page-loader.vue';

    export default {
    	data() {
    		return {
    			title: 'SOAP Object Configuration',
    			newSoapObj: null,
                soapObjs: [1, 2, 3, 4, 5, 6],
                soapObjErrors: []
    		};
    	},
    	methods: {
            checkSoapObjErrors() {
                if(this.newSoapObj) {
                    this.soapObjErrors = [];
                    return false;
                }else {
                    if(!this.newSoapObj) this.soapObjErrors.push('SOAP Object Required');
                    return true;
                };
            },

            loadSoapObj() {
                EM.$emit(PageLoader.SHOW);
                API.getSoapObj().then(data => {
                    EM.$emit(PageLoader.HIDDEN);
                    this.soapObjs = data;
                });
            },

            saveSoapObj() {
                if(!this.checkSoapObjErrors()) {
                    EM.$emit(PageLoader.SHOW);
                    let saveSoapObj = this.newSoapObj;
                    API.saveSoapObj(saveSoapObj).then(data => {
                        EM.$emit(PageLoader.HIDDEN);
                        console.log(data);
                    });
                };
            },
            deleteSoapObj() {//Need to come back to this, how to tell which 'delete' bttn corresponds to which inout field
                EM.$emit(PageLoader.SHOW);
                API.deleteSoapObj(soapObjToDelete).then(data => {
                    EM.$emit(PageLoader.HIDDEN);
                    console.log(data);
                });

            }
        },
        mounted() {
            // this.loadSoapObj(); //Waiting on final Object-Configuration end-point API
        }
    }
</script>

<style scoped>
</style>
