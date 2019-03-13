<template>
    <section>
        <h1 class="slds-text-heading_large slds-m-bottom_x-large">Object Configuration</h1>
        <section class="primary-section">
            <form @submit.prevent="saveSoapObj" class="slds-form-element__form">
                <label class="slds-form-element__label">{{ title }}</label>
                <input class="slds-form-element__input" type="text" v-model="description"/>
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
    			description: null
    		}
    	},
    	methods: {
            checkSoapObjErrors() {

            },

            loadSoapObj() {

            },

            saveSoapObj() {
                if(!checkSoapObjErrors()) {
                    
                }

            },
            deleteSoapObj() {

            }
        },
        mounted() {

        }
    }
</script>

<style scoped>

</style>
